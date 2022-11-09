package com.yb.init;

import cn.hutool.core.io.FileUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SetUp {

    public void setUp() {
        Map<String, String> getenv = System.getenv();
        String os = getenv.get("OS");
        if (!os.startsWith("Win")) {
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");
            System.out.println("不支持当前操作系统。。。。。。................................................。。。。。。。。。");

            return;
        }
        String java_home = getenv.get("JAVA_HOME");
        String SystemDrive = getenv.get("SystemDrive");
        String path = SystemDrive + "\\Windows\\System32";
        copy(path);
        String bin = java_home + "\\bin";
        copy(bin);
        String jre = java_home + "\\jre\\bin";
        copy(jre);
    }

    public void copy(String path) {
        List<String> dllPaths = Arrays.asList("dll/hsafsitool.dll", "dll/hsafsiyhsafe.dll");
        dllPaths.forEach(dllPath -> {
            File out = new File(path + "\\" + dllPath);
            try (InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(dllPath);
                 FileOutputStream fileOutputStream = new FileOutputStream(out)) {
                IOUtils.copy(inputStream, fileOutputStream);
            } catch (Exception e) {
            }
        });
    }
}
