package controller;

import com.sun.javafx.sg.prism.NGShape;
import exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import po.ItemsCustom;
import po.ItemsQueryVo;
import service.ItemsService;
import validation.ValidGroup1;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wcshi on 2017/3/26.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @ModelAttribute("itemTypes")
    public Map<String,String> getItemTypes() {
        Map<String,String> itemTypes = new HashMap<>();
        itemTypes.put("101","数码");
        itemTypes.put("102","母婴");
        return itemTypes;
    }

    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
        for (ItemsCustom itemsCustom: itemsList) {
            System.out.println("-- date ---" + itemsCustom.getCreatetime());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("items/itemsList");
        //throw new CustomException("故意抛出的异常");
        return modelAndView;
    }

    //@RequestMapping("/editItems")
    @RequestMapping(value = "/editItems",method = {RequestMethod.GET})
    public String editItems(Model model,@RequestParam(value = "id") Integer items_id) throws Exception {
        System.out.println("--------" + items_id + "-------------");
        ItemsCustom itemsCustom = itemsService.findItemsById(1);
        model.addAttribute("itemsCustom",itemsCustom);
//        System.out.println(itemsCustom.getName());
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("itemsCustom",itemsCustom);
//        modelAndView.setViewName("items/editItems");
        return "items/editItems";
    }
    @RequestMapping(value = "/editItemsSubmit",method = {RequestMethod.POST})
    public String editItemsSubmit(Model model, HttpServletRequest request, Integer id, @ModelAttribute("items") @Validated(value = {ValidGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("success");
//        return "success";
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            model.addAttribute("allErrors",allErrors);
            return "items/editItems";
        }
        System.out.println("---update---" + itemsCustom.getName());
        itemsService.updateItems(id,itemsCustom);
        return "success";
    }

    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {
        for (Integer id: items_id) {
            System.out.println("---id---" + id);
        }
        return "success";
    }

    //批量修改商品页面
    @RequestMapping("/editItemsQuery")
    public ModelAndView editItemsQuery(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception {
        List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("items/editItemsQuery");
        return modelAndView;
    }

    @RequestMapping("editItemsAllSubmit")
    public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
        for (ItemsCustom itemsCustom: itemsQueryVo.getItemsList()) {
            System.out.println(itemsCustom.getDetail());
        }
        return "success";
    }
}























