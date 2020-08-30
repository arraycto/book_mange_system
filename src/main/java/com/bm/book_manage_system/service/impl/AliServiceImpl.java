package com.bm.book_manage_system.service.impl;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.bm.book_manage_system.config.AliConfig;
import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.domain.PayRecord;
import com.bm.book_manage_system.service.AliService;
import com.bm.book_manage_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class AliServiceImpl implements AliService {

    @Autowired
    OrderService orderService;

    //该方法是支付请求发送到支付宝的时候支付包很快会调用的方法但这个时候支付宝可能还没有扣款成功
    //这个回调主要用来给前台一个快速的响应
    @Override
    public String synchronousFallback(HttpServletRequest request) {
        //这里现在并没有什么业务需要处理以后有了再加
        return "/redirect";
    }

    //支付宝扣款成功时回调的方法(异步回调)
    @Override
    public void notifyFallback(HttpServletRequest request, HttpServletResponse response) {
        //校验参数并修改订单状态
        String appId = request.getParameter("app_id");
        String tradeNo = request.getParameter("out_trade_no"); //订单号
        String tradeStatus = request.getParameter("trade_status");  //交易结果
        if(!appId.equals(AliConfig.app_id)) {
            return;    //说明不是这个应用的交易单
        }
        PayRecord record = orderService.getPayRecordById(tradeNo); //得到对应支付记录
        switch (tradeStatus) {
            case "TRADE_SUCCESS":  //支付成功
                orderService.orderDeal(record); //修改订单为支付态
                break;
            case "TRADE_CLOSED":  //交易终止(失败)
                orderService.cancelOrderByIds(tradeNo);  //修改订单为取消态
                break;
            case "TRADE_FINISHED": //交易完结
                break;
            case "WAIT_BUYER_PAY": //交易创建，等待支付
        }
    }

    @Deprecated
    protected boolean doPay(HttpServletResponse response, Order order) {
        //设置编码
        response.setContentType("text/html;charset=utf-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliConfig.gatewayUrl, AliConfig.app_id, AliConfig.merchant_private_key, "json", AliConfig.charset, AliConfig.alipay_public_key, AliConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AliConfig.return_url);
        aliPayRequest.setNotifyUrl(AliConfig.notify_url);

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String orderNumber = order.getOrderId();

        //订单名称，必填
        String subject = "**书店会员支付订单";
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + orderNumber + "\","
                + "\"total_amount\":\"" + order.getAmount() + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"timeout_express\":\" 5m,\" "   //过期时间
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        try {
            alipayClient.pageExecute(aliPayRequest, "POST"); //请求支付宝
            //保存支付记录
            PayRecord payRecord = new PayRecord();
            payRecord.setOrderId(order.getOrderId());
            payRecord.setAmount(order.getAmount());
            payRecord.setVipId(order.getVipId());
            orderService.savePayRecords(payRecord);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
