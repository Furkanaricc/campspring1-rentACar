package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import java.util.*;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
}