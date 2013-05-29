package com.blogspot.tanakanbb.process;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Hello world!
 * 
 */
public class AppTest {
    /**
     * プロパティ
     */
    private static Map<Integer, Date> map = new ConcurrentHashMap<Integer, Date>();
    
    public static void main(String[] args) {
        ShutdownHook target = new AbstractShutdownHook() {
            
            @Override
            public void release() {
                map.clear();
                System.out.println("map size : " + map.size());
            }
            
            @Override
            public void doExecute() {
                RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
                String vmName = bean.getName();
                long pid = Long.valueOf(vmName.split("@")[0]);
                
                System.out.println("pid : " + pid);
                
                int count = 0;
                while (true) {
                    Date systemDate = new Date();
                    map.put(Integer.valueOf(count++), systemDate);
                    System.out.println("map size : " + map.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        
        target.execute();
    }
}
