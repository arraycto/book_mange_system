package com.bm.book_manage_system.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.bm.book_manage_system.config.AliConfig;
import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.domain.PayRecord;
import com.bm.book_manage_system.service.AliService;
import com.bm.book_manage_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("pay")
@ResponseBody
public class AliController {

    @Autowired
    AliService aliService;

    @Autowired
    OrderService orderService;

    @PostMapping("/getQRCode")
    public void pay(HttpServletResponse response, Order order) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AliConfig.gatewayUrl, AliConfig.app_id, AliConfig.merchant_private_key,
                "json", AliConfig.input_charset, AliConfig.alipay_public_key, "RSA2");
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AliConfig.return_url);
        aliPayRequest.setNotifyUrl(AliConfig.notify_url);
        //商品名称
        String subject = "**书店会员支付";
        //商品描述，可以为空
        String body = "**书店会员卡充值";
        //填充业务参数
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order.getOrderId() + "\","
                + "\"total_amount\":\"" + order.getAmount() + "\","
                + "\"goodsType\":\" 0,\" " //商品主类型 :0-虚拟类商品,1-实物类商品
                + "\"subject\":\"" + subject + "\","
                + "\"timeout_express\":\" 5m,\" "   //过期时间
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String form = "";
        try {
            form = alipayClient.pageExecute(aliPayRequest).getBody(); //调用SDK生成表单
            //保存支付记录
            PayRecord payRecord = new PayRecord();
            payRecord.setOrderId(order.getOrderId());
            payRecord.setAmount(order.getAmount());
            payRecord.setVipId(order.getVipId());
            orderService.savePayRecords(payRecord);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 回调页面
     *
     * @return
     */
    @GetMapping("/success")
    public String success() {
        return "支付成功";
    }

    //支付宝调用成功回调接口
    @GetMapping(value = "/synchronousFallback")
    public void synchronousFallback(HttpServletRequest request, HttpServletResponse response) {
        aliService.synchronousFallback(request);
        try {
            response.sendRedirect("https://www.baidu.com");
            return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //支付宝扣费业务处理完成（成功/失败）回调接口
    @PostMapping(value = "/notifyFallback")
    public void notifyFallback(HttpServletRequest request, HttpServletResponse response) {
        aliService.notifyFallback(request, response);
    }
}
