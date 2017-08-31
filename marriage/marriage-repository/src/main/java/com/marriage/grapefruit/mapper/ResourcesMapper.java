package com.marriage.grapefruit.mapper;

import java.util.List;
import java.util.Map;

import com.marriage.grapefruit.model.Resources;
import com.marriage.grapefruit.utils.MarriageMapper;

public interface ResourcesMapper extends MarriageMapper<Resources>{

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String,Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
