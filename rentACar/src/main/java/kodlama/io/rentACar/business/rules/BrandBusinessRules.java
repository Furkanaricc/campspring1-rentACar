package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void chechIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand allready exists.");
        }

    }
}