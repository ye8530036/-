package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.model.*;
import com.example.service.IHouseService;
import com.example.service.IPropertyInfoService;
import com.example.service.IPropertyTypeService;
import com.example.util.JsonObject;
import com.example.util.R;
import com.github.pagehelper.PageInfo;
import com.example.service.IOwnerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


@Api(tags = {""})
@RestController
@RequestMapping("/propertyinfo")
public class PropertyInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPropertyInfoService propertyInfoService;

    @Resource
    private IHouseService houseService;

    @Resource
    private IOwnerService ownerService;

    @Resource
    private IPropertyTypeService propertyTypeService;

    @RequestMapping("/queryPropertyAll")
    public JsonObject queryPropertyAll(PropertyInfo propertyInfo, String numbers,
                                       @RequestParam(defaultValue = "1") Integer page,
                                       @RequestParam(defaultValue = "15") Integer limit){
        if(numbers!=null){
            House house=new House();
            house.setNumbers(numbers);
            propertyInfo.setHouse(house);
        }

        PageInfo<PropertyInfo> pageInfo=propertyInfoService.findPropertyInfoAll(page,limit,propertyInfo);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }


    @RequestMapping("/queryPropertyAll2")
    public JsonObject queryPropertyAll2(PropertyInfo propertyInfo, HttpServletRequest request,
                                       @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit){
        Userinfo userinfo= (Userinfo) request.getSession().getAttribute("user");
        String username=userinfo.getUsername();
        //??????username???????????????????????????id
          Owner owner=ownerService.queryOwnerByName(username);
//        Integer userId=owner.getId();
//        carcharge.setOwnerId(userId);
          Integer houId= owner.getHouseId();
          propertyInfo.setHouseId(houId);

        PageInfo<PropertyInfo> pageInfo=propertyInfoService.findPropertyInfoAll(page,limit,
                propertyInfo);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());

    }


    @ApiOperation(value = "??????")
    @RequestMapping("/initData")
    public R initData(@RequestBody PropertyInfo propertyInfo){
        //??????????????????  ????????????  ??????
        List<House> list=houseService.findList();
        for(House house:list){
           //??????????????????????????????  ?????? ????????????????????????????????????
            PropertyType type=propertyTypeService.findById(new Long(1));
            double price=type.getPrice();//????????????
            Integer status= house.getStatus();
            if(status!=null || status!=0){//??????????????????
                  //?????????
              double money=  house.getArea()*price;
                propertyInfo.setMoney(money);
                propertyInfo.setHouseId(house.getId());
                propertyInfo.setStatus(0);
                propertyInfo.setTypeId(1);
                propertyInfoService.add(propertyInfo);
            }
        }

        return R.ok();
    }





    @ApiOperation(value = "??????")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        for(String id:list){
            Long idLong=new Long(id);
            propertyInfoService.delete(idLong);
        }
        return R.ok();
    }


    @ApiOperation(value = "??????")
    @RequestMapping("/update")
    public R update(Integer id){
        PropertyInfo propertyInfo =new PropertyInfo();
        propertyInfo.setId(id);
        propertyInfo.setStatus(1);
        int num=propertyInfoService.updateData(propertyInfo);
        if(num>0){
            return R.ok();
        }
        return R.fail("??????");
    }

    @ApiOperation(value = "??????????????????")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "??????"),
        @ApiImplicitParam(name = "pageCount", value = "????????????")
    })
    @GetMapping()
    public IPage<PropertyInfo> findListByPage(@RequestParam Integer page,
                                              @RequestParam Integer pageCount){
        return propertyInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id??????")
    @GetMapping("{id}")
    public PropertyInfo findById(@PathVariable Long id){
        return propertyInfoService.findById(id);
    }

}
