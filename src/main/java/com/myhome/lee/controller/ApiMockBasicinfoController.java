
package com.myhome.lee.controller;

import com.myhome.lee.entity.ApiMockBasicinfo;
import com.myhome.lee.entity.Project;
import com.myhome.lee.repository.ApiMockBasicinfoRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lee on 2017/5/3.
 */
@RestController
@RequestMapping(value="/apimock")     // 通过这里配置使下面的映射都在/users下，可去除
/**
 * http://blog.didispace.com/springbootrestfulapi/
 * http://blog.didispace.com/spring-boot-learning-1/
 * http://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
 */
public class ApiMockBasicinfoController {

    @Autowired
    private ApiMockBasicinfoRepository apiMockBasicinfoRepository;

    final Logger logger = LoggerFactory.getLogger(ApiMockBasicinfoController.class);


    @ApiOperation(value = "获取apimock列表", notes = "无参数获取apimock列表")
    @RequestMapping(value="/", method= RequestMethod.GET)
    @ResponseBody
    public List<ApiMockBasicinfo> getApiMockBasicinfoList() throws IOException {
        List<ApiMockBasicinfo> apiMockBasicinfoList = apiMockBasicinfoRepository.findAll();
        logger.info("apiMockBasicinfoList==="+ apiMockBasicinfoList.toString());
        return apiMockBasicinfoList;
    }

    @ApiOperation(value = "获取apimock列表by projectid", notes = "根据projectId获取apimock列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "projectId", required = false, dataType = "Integer", paramType = "path", defaultValue = "0")
    })
    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public List<ApiMockBasicinfo> getApiMockBasicinfoListByProjectId(@PathVariable Integer projectId) throws IOException {
        List<ApiMockBasicinfo> apiMockBasicinfoList = apiMockBasicinfoRepository.findApiMockBasicinfoListByProjectId(projectId);

        logger.info("apiMockBasicinfoList===" + apiMockBasicinfoList.toString());
        return apiMockBasicinfoList;
    }

    @ApiOperation(value = "获取apimock详细信息", notes = "根据apimockid获取详细信息")
    @RequestMapping(value = "/{apimockId}", method = RequestMethod.GET)
    @ResponseBody
    public ApiMockBasicinfo getApiMockBasicinfo(@PathVariable Integer apimockId) {
        ApiMockBasicinfo apiMockBasicinfo = apiMockBasicinfoRepository.findById(apimockId);
        return apiMockBasicinfo;
    }

    @ApiOperation(value = "获取apimock列表分页", notes = "根据页数和默认10条获取apimockid列表，按照id升序排列")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "page", required = false, dataType = "int", paramType = "query", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "size", required = false, dataType = "int", paramType = "query", defaultValue = "10")
    })
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public Page<ApiMockBasicinfo> getApiMockBasicinfoListByPageParams(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "projectId", defaultValue = "0") Integer projectId, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        logger.info("===============getApiMockBasicinfoListByPageParams-start=========================================");
        if (page <= 0) {
            page = 1;
        }
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Project project = new Project();
        project.setId(projectId);

        Page<ApiMockBasicinfo> pages = apiMockBasicinfoRepository.findByProjectIdIn(projectId, pageable);
        Iterator<ApiMockBasicinfo> it = pages.iterator();
        while (it.hasNext()) {
            ApiMockBasicinfo apiMockBasicinfo = (ApiMockBasicinfo) it.next();
            logger.info("page" + page + "-apimockid:" + apiMockBasicinfo.getId() + "-projectid--" + apiMockBasicinfo.getProjectId());
        }

        logger.info("===============getApiMockBasicinfoListByPageParams-end=========================================");

        pages.getTotalPages();
        return pages;
    }

    @ApiOperation(value = "获取apimock列表分页old", notes = "根据页数和默认10条获取apimockid列表，按照id升序排列")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "page", required = false, dataType = "int", paramType = "query", defaultValue = "0"),
            @ApiImplicitParam(name = "size", value = "size", required = false, dataType = "int", paramType = "query", defaultValue = "10")
    })
    @RequestMapping(value = "/oldpage", method = RequestMethod.GET)
    @ResponseBody
    public Page<ApiMockBasicinfo> getApiMockBasicinfoListByParamsOld(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "projectId", defaultValue = "0") Integer projectId, @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page - 1, size, sort);
        Project project = new Project();
        project.setId(projectId);

        Page<ApiMockBasicinfo> pages1 = apiMockBasicinfoRepository.findByProjectIdIn(projectId, pageable);
        logger.info("pages1===" + pages1);

        Iterator<ApiMockBasicinfo> itt = pages1.iterator();
        while (itt.hasNext()) {
            ApiMockBasicinfo apiMockBasicinfo = (ApiMockBasicinfo) itt.next();
            logger.info("page1-apimockid:" + apiMockBasicinfo.getId() + "-projectid--" + apiMockBasicinfo.getProjectId());
        }

        logger.info("========================================================");
        logger.info("========================================================");
        Page<ApiMockBasicinfo> pages = apiMockBasicinfoRepository.findAll(pageable);
        pages.getTotalPages();

//        Page<ApiMockBasicinfo> pages = apiMockBasicinfoRepository.findAll(new Specification<ApiMockBasicinfo> () {
//
//            public Predicate toPredicate(Root<ApiMockBasicinfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//
//                //JpaSort.Path<String> idPath = root.get("project_id");
//                /**
//                 * 连接查询条件, 不定参数，可以连接0..N个查询条件
//                 */
//               // Predicate p1 = cb.equal(root.get("project_id"),projectId);
//                query.where(cb.equal(root.get("project_id"),projectId));
//                //query.where(cb.like(idPath, "%李%")); //这里可以设置任意条查询条件
//
//                return null;//query.getRestriction();
//            }
//
//
//        }, page);


        Iterator<ApiMockBasicinfo> it = pages.iterator();
        while (it.hasNext()) {
            logger.info("apimockid:" + ((ApiMockBasicinfo) it.next()).getId());
        }
        return pages;
    }

    /**
     * 创建动态查询条件组合.
     */
//    private Specification<Task> buildSpecification(Integer projectId, Map<String, Object> searchParams) {
//        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
//        filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
//        Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
//        return spec;
//    }

}
