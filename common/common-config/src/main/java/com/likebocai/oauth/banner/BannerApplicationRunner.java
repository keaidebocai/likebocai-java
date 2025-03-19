package com.likebocai.oauth.banner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author likebocai
 * @description: 项目启动成功后，提供文档相关的地址
 * @date 2025/3/19 15:54
 */
@Slf4j
@Component // 修改点：添加 @Component 注解，确保该类被 Spring 管理
public class BannerApplicationRunner {

    /**
     * 监听 ApplicationReadyEvent 事件，确保应用完全启动后再执行
     */
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() throws Exception {
        // 睡一秒保证出现在日志最底层
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        List<String> address = getStrings();
        // 获取本机[ip][端口]
        String hostName = InetAddress.getLocalHost().getHostName();
        // 本机端口号
        String port = "16281";

        log.info("\n----------------------------------------------------------\n\t" +
                "菠菜的小窝-oauth-项目启动成功！\n\t" +
                "本机信息: \t{}", hostName);
        address.forEach(item -> {
            System.out.print("\t文档接口: \thttp://" + item + ":" + port + "/doc.html\n");
        });
        System.out.println("----------------------------------------------------------");
    }

    /**
     * 获取本机所有非虚拟、非回环地址的 IP 地址
     */
    private static List<String> getStrings() throws SocketException {
        List<String> address = new ArrayList<>();
        Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
        for (NetworkInterface netint : Collections.list(networks)) {
            // 排除虚拟网卡和loopback地址
            if (netint.isVirtual() || netint.isLoopback() || !netint.isUp()) {
                continue;
            }

            Enumeration<InetAddress> addresses = netint.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                // 过滤掉IPv6的临时地址（如果有需要的话）
                if (addr instanceof java.net.Inet6Address) {
                    java.net.Inet6Address inet6Addr = (java.net.Inet6Address) addr;
//                    if (inet6Addr.isLinkLocalAddress()) {
//                        continue;
//                    }
                    continue;
                }
                address.add(addr.getHostAddress());
            }
        }
        return address;
    }
}