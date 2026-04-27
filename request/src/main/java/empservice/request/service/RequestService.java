package empservice.request.service;

import java.util.List;

import org.springframework.stereotype.Service;
import empservice.request.repository.RequestRepository;
import empservice.request.model.Request;

@Service
public class RequestService {

RequestRepository requestRepository;
RequestService(RequestRepository requestRepository){
    this.requestRepository = requestRepository; 
}

public Request getRequestById(long id){
    return requestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
}

public Request getRequestByEmpNo(long empNo){
    return requestRepository.findAll().stream().filter(r -> r.getEmpno() == empNo).findFirst().orElseThrow(() -> new RuntimeException("Request not found"));
}

public List<Request> getAllRequests(){
    return requestRepository.findAll();
}

public Request createRequest(long empNo){
    Request request = new Request(empNo);
    return requestRepository.save(request);
}

public Request deleteRequest(long id){
    Request request = requestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    requestRepository.delete(request);
    return request;
   
}

public Request updateRequestStatus(long id, String status){
    Request request = requestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request not found"));
    request.setStatus(status);
    return requestRepository.save(request);

}
}