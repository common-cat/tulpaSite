package wiki.common_cat.auditService.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wiki.common_cat.auditService.service.AuditService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class AuditController {
    @Resource(name = "commonAuditService")
    private AuditService service;
    @PostMapping("/audit/commit")
    public void commit(HttpServletRequest request){
        service.commit(request.getParameter("sessionID"));
    }
    @PostMapping("/audit/reject/{id}")
    public void reject(HttpServletRequest httpServletRequest,@PathVariable("id")String id){
        if(service.isAdmin(httpServletRequest.getParameter("sessionID"))){
            service.reject(Integer.valueOf(id),httpServletRequest.getParameter("comment"));
        }
    }
    @PostMapping("/audit/accept/{id}")
    public void accept(HttpServletRequest httpServletRequest,@PathVariable("id")String id){
        if(service.isAdmin(httpServletRequest.getParameter("sessionID"))){
            service.accept(Integer.valueOf(id),httpServletRequest.getParameter("comment"));
        }
    }
    @PostMapping("/audit/aduitlist")
    public String auditList(HttpServletRequest httpServletRequest){
        if(service.isAdmin(httpServletRequest.getParameter("sessionID"))){
            return service.getAuditList();
        }
        return "";
    }
}
