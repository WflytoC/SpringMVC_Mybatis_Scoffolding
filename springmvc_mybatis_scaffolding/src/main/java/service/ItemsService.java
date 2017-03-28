package service;

import po.ItemsCustom;
import po.ItemsQueryVo;

import java.util.List;

/**
 * Created by wcshi on 2017/3/26.
 */
public interface ItemsService {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
    public ItemsCustom findItemsById(Integer id) throws Exception;

    /**
     *
     * @param id
     * @param itemsCustom
     * @throws Exception
     */
    public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}












