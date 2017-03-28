package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import po.Items;
import po.ItemsCustom;
import service.ItemsService;

/**
 * Created by wcshi on 2017/3/27.
 */
@Controller
public class JsonTestController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/requestJson",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) throws Exception {
        return itemsCustom;
    }

    @RequestMapping("/responseJson")
    @ResponseBody
    public ItemsCustom responseJson(ItemsCustom itemsCustom) {
        return itemsCustom;
    }

    @RequestMapping("/viewItems/{id}")
    @ResponseBody
    public ItemsCustom viewItems(@PathVariable("id") Integer id, Model model) throws Exception {
        ItemsCustom itemsCustom = itemsService.findItemsById((Integer)id);
        return itemsCustom;
    }
}










