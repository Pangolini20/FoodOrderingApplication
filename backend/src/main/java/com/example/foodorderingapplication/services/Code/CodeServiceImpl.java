package com.example.foodorderingapplication.services.Code;

import com.example.foodorderingapplication.db.entities.Code;
import com.example.foodorderingapplication.db.entities.Restaurant;
import com.example.foodorderingapplication.db.repository.CodeRepository;
import com.example.foodorderingapplication.db.repository.RestaurantRepository;
import com.example.foodorderingapplication.dto.CodeDetails;
import com.example.foodorderingapplication.dto.CodeDto;
import com.example.foodorderingapplication.exceptions.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeRepository codeRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public CodeDto createCode(Long id,CodeDetails codeDetails) {

        Code code = new Code();
        code.setExpirationDate(codeDetails.getExpirationDate());
        code.setName(codeDetails.getName());
        code.setValue(codeDetails.getValue());

        Optional<Restaurant> opt = restaurantRepository.findById(id);
        if(opt.isEmpty())
            throw new NoDataFoundException();

        code.setRestaurant(opt.get());

        code=codeRepository.save(code);

        return new CodeDto(code.getId(),id,code.getName(),code.getValue(),code.getExpirationDate());
    }

    @Override
    public CodeDto editCode(Long id, CodeDetails codeDetails) {
        Code code = new Code();
        code.setExpirationDate(codeDetails.getExpirationDate());
        code.setName(codeDetails.getName());
        code.setValue(codeDetails.getValue());

        Optional<Restaurant> opt = restaurantRepository.findById(id);
        if(opt.isEmpty())
            throw new NoDataFoundException();

        code.setRestaurant(opt.get());

        code=codeRepository.save(code);

        return new CodeDto(code.getId(),id,code.getName(),code.getValue(),code.getExpirationDate());
    }

    @Override
    public void deleteCode(Long id) {
        codeRepository.delete(codeRepository.getById(id));
    }

    @Override
    public List<CodeDto> getRestaurantCodes(Long id) {
        return codeRepository.findRestaurantCodes(id);
    }


}
