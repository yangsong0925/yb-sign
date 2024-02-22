package com.yb.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yb.common.R;
import com.yb.jna.HsafsitoolLibrary;
import com.yb.jna.HsafsiyhsafeLibrary;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 医保对码
 *
 * @name: MappingController
 * @author: tq
 * @date: 2022-02-24 10:32
 **/
@Log4j2
@RestController
//@RequestMapping("/yb")
public class YbController {

    @PostMapping("gm_sign_key")
    public R<String> gm_sign_key(@RequestBody Map<String, String> body) {
        String signSource = MapUtil.getStr(body, "input");
        String priKey = MapUtil.getStr(body, "priKey");
        String pubKey = MapUtil.getStr(body, "pubKey");
        byte[] bytes = signSource.getBytes(StandardCharsets.UTF_8);
        byte[] returnStr = new byte[bytes.length + (1024 * 10)];
        int count = HsafsitoolLibrary.INSTANCE.gm_sign_key(null, priKey, pubKey, bytes, bytes.length, returnStr);
        if (count < 0) {
            return R.error("加密失败，错误编码：" + count);
        }
        String cainfo = new String(returnStr, StandardCharsets.UTF_8);
        return R.success(cainfo.trim());
    }

    @PostMapping("gm_ecb_encrypt_key")
    public R<String> gm_ecb_encrypt_key(@RequestBody Map<String, String> body) {
        String input = MapUtil.getStr(body, "input");
        String priKey = MapUtil.getStr(body, "priKey");
        String pubKey = MapUtil.getStr(body, "pubKey");
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        byte[] returnStr = new byte[bytes.length + (1024 * 10)];
        int count = HsafsiyhsafeLibrary.INSTANCE.gm_ecb_encrypt_key(pubKey, bytes, bytes.length, returnStr);
        if (count < 0) {
            return R.error("加密失败，错误编码：" + count);
        }
        String inputRe = new String(returnStr, StandardCharsets.UTF_8);
        return R.success(inputRe.trim());
    }

    @PostMapping("gm_ecb_decrypt_key")
    public R<String> gm_ecb_decrypt_key(@RequestBody Map<String, String> body) {
        String input = MapUtil.getStr(body, "input");
        String priKey = MapUtil.getStr(body, "priKey");
        String pubKey = MapUtil.getStr(body, "pubKey");
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        byte[] returnStr = new byte[bytes.length + (1024 * 10)];
        int count = HsafsiyhsafeLibrary.INSTANCE.gm_ecb_decrypt_key(pubKey, bytes, bytes.length, returnStr);
        if (count < 0) {
            return R.error("加密失败，错误编码：" + count);
        }
        String inputRe = new String(returnStr, StandardCharsets.UTF_8);
        return R.success(inputRe.trim());
    }
}
