package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    @Override
    public List<GetAllModelsResponse> getAll() {
        return null;
    }
}
