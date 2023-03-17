package kodlama.io.rentACar.core.utilities.mappers;

import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap;
import kodlama.io.rentACar.entitiy.concretes.Model;
import org.modelmapper.ModelMapper;

public interface ModelMappersService {
    ModelMapper forResponse();
    ModelMapper forRequest();


}
