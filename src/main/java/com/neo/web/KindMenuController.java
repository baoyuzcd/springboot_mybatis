package com.neo.web;

import com.dfire.soa.item.bo.KindMenu;
import com.dfire.soa.item.service.IBackstageService;
import com.dfire.soa.item.service.IGetAdditionService;
import com.dfire.soa.item.service.IGetMenuService;
import com.dfire.soa.item.service.IGetTasteService;
import com.dfire.soa.item.vo.AdditionKindMenuVo;
import com.dfire.soa.item.vo.KindAndTasteVo;
import com.twodfire.share.result.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @date 2018/11/2
 */
@Controller

public class KindMenuController {
    @Resource
    private IGetMenuService getMenuService;

    @Resource
    private IGetAdditionService getAdditionService;

    @Resource
    private IGetTasteService getTasteService;

    @Resource
	private IBackstageService backstageService;

    @RequestMapping("/kindmenu")
    public String kindmenu(){
        return "item/kindmenu";
    }

    @RequestMapping("/kindmenudetail")
    public String kindmenudetail(@RequestParam("entityId") String entityId,
                                 @RequestParam("types") Integer types,
                                 Model model) {
        Result<List<KindMenu>> result = getMenuService.queryKindMenuList(entityId, types);
        List<KindMenu> kindMenuList = result.getModel();
        Boolean kflag = null;

        if (CollectionUtils.isNotEmpty(kindMenuList)){
            Map<String, Integer> level = new HashMap(16);

            for (KindMenu kindMenu1 : kindMenuList) {
                if ("0".equals(kindMenu1.getParentId())) {
                    level.put(kindMenu1.getId(), 1);
                }

            }
            model.addAttribute("kindMenuList", kindMenuList);
            model.addAttribute("types", types);
            model.addAttribute("entityId", entityId);
            model.addAttribute("level", 1);
            kflag = true;
        }
        else {
            kflag = false;
        }

        model.addAttribute("kflag",kflag);
        return "item/kindmenudetail";
    }



}
