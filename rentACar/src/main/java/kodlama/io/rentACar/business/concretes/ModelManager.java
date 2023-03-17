package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entitiy.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMappersService modelMappersService;



    @Override
    public List<GetAllModelResponse> getAll(List<GetAllModelResponse> modelsResponse) {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponse>ModelsResponses = models.stream().
                map(model->this.modelMappersService.forResponse() .map(model,GetAllModelResponse.class))
                .collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this.modelMappersService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);

    }

    @Override
    public List<GetAllModelResponse> getAll() {
        return null;
    }
}
