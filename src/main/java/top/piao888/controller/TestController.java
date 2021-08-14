package top.piao888.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import top.piao888.service.OrderService;


/**
 * @author 许鸿志
 * @since 2021/8/14
 */
@Controller
@RequestMapping("/hi")
@Data
public class TestController {
    @Autowired
    private OrderService orderService;
    private static Logger logger = Logger.getLogger(TestController.class);

    @GetMapping("/logger")
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        resp.getWriter().println("test logger");

        logger.info("这是一条日志信息 - jiafuwei");
    }

    @GetMapping("order")
    public String order() {
        orderService.simulation();
        return "order";
    }

}
