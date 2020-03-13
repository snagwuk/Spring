package main;

import src.AuthenticationService;
import sensor.Monitor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainByAll {

        public static void main(String[] args) {
                GenericXmlApplicationContext ctx =
                                new GenericXmlApplicationContext("classpath:config-all.xml");
                AuthenticationService authSvc =
                                ctx.getBean("authenticationService", AuthenticationService.class);
                authSvc.authenticate("bkchoi", "1234");

                Monitor monitor = ctx.getBean(Monitor.class);
                System.out.println(monitor);
                ctx.close();
        }

}
