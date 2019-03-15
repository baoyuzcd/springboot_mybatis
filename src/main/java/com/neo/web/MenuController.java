package com.neo.web;


import com.dfire.soa.item.bo.Menu;
import com.dfire.soa.item.bo.MenuProp;
import com.dfire.soa.item.platform.bo.TisQueryBO;
import com.dfire.soa.item.platform.service.read.IItemSolrQueryService;
import com.dfire.soa.item.service.IGetMenuService;
import com.dfire.soa.item.vo.MenuVO;
import com.twodfire.share.result.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Controller
public class MenuController {



    @Resource
     IGetMenuService getMenuService;

    @Resource
    private IItemSolrQueryService itemSolrQueryService;

    /*登录之后就跳转到menu初始页面*/
    @RequestMapping("/menu")
    public String menu(){
        return "item/menu";
    }


    //进入菜单查询
    @PostMapping("/menudetail")
    public String querymenu(@RequestParam("menuId") String menuId,
                            Model model){
        if (menuId.length() > 8){
            String entityId = menuId.substring(0,8);
            Result<Menu> menuVOResult = getMenuService.queryMenu(entityId, menuId);
            if (null != menuVOResult.getModel() && menuVOResult.isSuccess()) {
                model.addAttribute("menu",menuVOResult.getModel());

                Result<MenuProp> menuPropResult = getMenuService.findMenuPropById(entityId, menuId);
                if (menuPropResult.isSuccess() && menuPropResult.getModel() != null) {
                    model.addAttribute("menuProp", menuPropResult.getModel());
                }

                return "item/menudetail";
            } else {
                model.addAttribute("success",false);
                return "item/menudetail";
            }
        }
        else {
            model.addAttribute("success",false);
            return "item/menudetail";
        }

    }

    @RequestMapping("/querymenubyentityid")
    public String querymenubyentityid() {
        return "item/querymenubyentityid";
    }


    @RequestMapping("/querymenubyentityiddetail")
    public String querymenubyentityiddetail(@RequestParam("entityId") String entityId,
                                            Model model) {
        Boolean flag = Boolean.TRUE;
        if (entityId.length() == 8) {
            TisQueryBO tisQueryBO = new TisQueryBO(entityId,1);

            Result<MenuVO> menuVOResult = itemSolrQueryService.getMenuVOResultFromSolr(tisQueryBO);
            if (menuVOResult.isSuccess() && menuVOResult.getModel() != null) {
                model.addAttribute("menuList", menuVOResult.getModel().getMenus());
            }
        } else {
            flag = Boolean.FALSE;
        }
        model.addAttribute("flag", flag);
        return "item/querymenubyentityiddetail";
    }
}
