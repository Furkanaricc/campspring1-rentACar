package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperManager;
import kodlama.io.rentACar.core.utilities.mappers.ModelMappersService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entitiy.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service //Bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
    private ModelMappersService modelMappersService;
    private BrandRepository brandRepository;
    private BrandBusinessRules brandBusinessRules;


    public BrandManager(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        //İş Kuralları
        List<Brand>brands = brandRepository.findAll();
        List<GetAllBrandResponse>brandResponse= new ArrayList<GetAllBrandResponse>();


        List<GetAllBrandResponse>brandResponses= (List<GetAllBrandResponse>) brands.stream().map(
                brand->this.modelMappersService.forResponse().map(brand,GetAllBrandResponse.class))
                .collect(Collectors.toList());
        //Stream in yanındaki stream api nin map i.tek te değerleri dönmesine yarar.For each in işini yapıyor.
        //brand i al ve gaetallbrandresponse a çevir
        //Collet ile de hepsini topla ve tolist e çevir

        return brandResponse  ;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response= this.modelMappersService.forResponse().map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.chechIfBrandNameExists(createBrandRequest.getName());

        Brand brand =this.modelMappersService.forRequest().map(createBrandRequest, Brand.class);
                this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand =this.modelMappersService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }
}
