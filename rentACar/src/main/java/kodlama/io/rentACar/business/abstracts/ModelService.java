package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelResponse;
import java.util.*;

public interface ModelService {
    List<GetAllModelResponse> getAll(List<GetAllModelResponse> modelsResponse);
    void add(CreateModelRequest createModelRequest);

    List<GetAllModelResponse> getAll();
}
