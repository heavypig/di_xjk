package com.ruoyi.project.system.cultrue.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.UUIDUtils;
import com.ruoyi.project.system.article.domain.SpArticle;
import com.ruoyi.project.system.dict.domain.DictData;
import com.ruoyi.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.cultrue.mapper.SpCultrueMapper;
import com.ruoyi.project.system.cultrue.domain.SpCultrue;
import com.ruoyi.project.system.cultrue.service.ISpCultrueService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 历史文化Service业务层处理
 * 
 * @author xingmc
 * @date 2020-10-12
 */
@Service
public class SpCultrueServiceImpl implements ISpCultrueService 
{
    @Autowired
    private SpCultrueMapper spCultrueMapper;
    @Autowired
    private IDictDataService dictDataService;

    /**
     * 查询历史文化
     * 
     * @param cultureId 历史文化ID
     * @return 历史文化
     */
    @Override
    public SpCultrue selectSpCultrueById(String cultureId)
    {
        return spCultrueMapper.selectSpCultrueById(cultureId);
    }

    /**
     * 查询历史文化列表
     * 
     * @param spCultrue 历史文化
     * @return 历史文化
     */
    @Override
    public List<SpCultrue> selectSpCultrueList(SpCultrue spCultrue)
    {
        return spCultrueMapper.selectSpCultrueList(spCultrue);
    }

    /**
     * 新增历史文化
     * 
     * @param spCultrue 历史文化
     * @return 结果
     */
    @Override
    public int insertSpCultrue(SpCultrue spCultrue)
    {
        spCultrue.setCultureId(UUIDUtils.getUUID());
        spCultrue.setCreateTime(DateUtils.getNowDate());
        return spCultrueMapper.insertSpCultrue(spCultrue);
    }

    /**
     * 修改历史文化
     * 
     * @param spCultrue 历史文化
     * @return 结果
     */
    @Override
    public int updateSpCultrue(SpCultrue spCultrue)
    {
        return spCultrueMapper.updateSpCultrue(spCultrue);
    }

    /**
     * 删除历史文化对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpCultrueByIds(String ids)
    {
        return spCultrueMapper.deleteSpCultrueByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除历史文化信息
     * 
     * @param cultureId 历史文化ID
     * @return 结果
     */
    @Override
    public int deleteSpCultrueById(String cultureId)
    {
        return spCultrueMapper.deleteSpCultrueById(cultureId);
    }

    @Override
    public Map<String, Object> getSpCultrueList(SpCultrue spCultrue) {
        DictData dictData = new DictData();
        dictData.setDictType("cul_column");
        List<DictData> dictlist = dictDataService.selectDictDataList(dictData);
        List<SpCultrue> spCultrues = spCultrueMapper.selectSpCultrueList(spCultrue);
        Map<String, Object> map = new HashMap<>();
        List<DictData> sizeList = new ArrayList<>();
        if (spCultrues.size() > 0) {
            for (int i = 0; i < dictlist.size(); i++ ){
                List<SpCultrue> sizelist = new ArrayList<>();
                DictData sizedata = new DictData();
                for (int j = 0; j < spCultrues.size(); j++ ){
                    if (dictlist.get(i).getDictValue().equals(spCultrues.get(j).getCulColumn())){
                        sizelist.add(spCultrues.get(j));
                    }
                }
                if(sizelist.size() > 0 ){
                    sizedata.setDictLabel(dictlist.get(i).getDictLabel());
                    sizedata.setDictValue(dictlist.get(i).getDictValue());
                    sizedata.setSpCultrueList(sizelist);
                    sizeList.add(sizedata);
                }
            }
        }

        map.put("sizelist",sizeList);
        map.put("code","200");
        return map;
    }
}
