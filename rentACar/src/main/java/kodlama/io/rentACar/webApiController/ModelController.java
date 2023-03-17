package kodlama.io.rentACar.webApiController;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/model")
@AllArgsConstructor
@NoArgsConstructor
public class ModelController {
    private ModelService modelService;
    private HttpStatus code;

    public ModelController (ModelService modelService){
        this.modelService=modelService;

    }

    @GetMapping()
    public List<GetAllModelResponse>getAll(){
        return modelService.getAll();
    }
   @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
   }

}
