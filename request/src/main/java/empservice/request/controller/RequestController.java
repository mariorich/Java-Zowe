package empservice.request.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import empservice.request.service.RequestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import empservice.request.model.Request;
import java.util.HashMap;


@RestController
@RequestMapping("/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/")
    public HashMap<String, Object> createRequest(@RequestParam long empNo) {
        Request entity = requestService.createRequest(empNo);
        HashMap<String, Object> response = new HashMap<>();    
        response.put("request", entity);
        return response;
    }
    
    @GetMapping("/")
    public HashMap<String, Object> getAllRequests() {
        HashMap<String, Object> response = new HashMap<>();    
        response.put("requests", requestService.getAllRequests());
        return response;
    }


}
