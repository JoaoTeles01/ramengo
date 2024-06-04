package com.api.ramengo.service;

import com.api.ramengo.entity.Broth;
import com.api.ramengo.entity.Protein;
import com.api.ramengo.exceptions.OrderException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RamenService {

    public List<Broth> getAvailableBroth(){
        return Arrays.asList(
                new Broth("Shoyu"),
                new Broth("Miso"),
                new Broth("Tonktsu")
        );
    }


    public List<Protein> getAvailableProteins(){
        return Arrays.asList(
                new Protein("Frango"),
                new Protein("Carne"),
                new Protein("Tofu")
        );

    }

    public String processOrder(String broth, String protein){
        List<String> availableBrothNames = getAvailableBroth().stream().map(Broth::getName_broth).collect(Collectors.toList());
        if (!availableBrothNames.contains(broth)){
            throw new OrderException("Caldo não disponivel: " + broth);
        }

        List<String> availableProteinsNames = getAvailableProteins().stream().map(Protein::getName_protein).collect(Collectors.toList());
        if (!availableProteinsNames.contains(protein)){
            throw new OrderException("Proteina não disponivel: " + protein);
        }

        String orderId = UUID.randomUUID().toString();
        return orderId;
    }

}
