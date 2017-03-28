package mapper;

import po.ItemsCustom;
import po.ItemsQueryVo;

import java.util.List;

/**
 * Created by wcshi on 2017/3/26.
 */
public interface ItemsMapperCustom {
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}







