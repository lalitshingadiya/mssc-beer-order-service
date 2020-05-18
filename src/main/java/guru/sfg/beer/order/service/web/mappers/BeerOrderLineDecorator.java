package guru.sfg.beer.order.service.web.mappers;

import guru.sfg.beer.order.service.domain.BeerOrderLine;
import guru.sfg.beer.order.service.services.BeerOrderRestTemplateService;
import guru.sfg.beer.order.service.web.model.BeerDto;
import guru.sfg.beer.order.service.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerOrderLineDecorator implements BeerOrderLineMapper{

    BeerOrderLineMapper beerOrderLineMapper;

    BeerOrderRestTemplateService beerOrderRestTemplateService;

    @Autowired
    public void setBeerOrderLineMapper(BeerOrderLineMapper beerOrderLineMapper){
        this.beerOrderLineMapper = beerOrderLineMapper;
    }

    @Autowired
    public void setBeerOrderRestTemplateService(BeerOrderRestTemplateService beerOrderRestTemplateService){
        this.beerOrderRestTemplateService = beerOrderRestTemplateService;
    }


    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {
        BeerOrderLineDto beerOrderLineDto = beerOrderLineMapper.beerOrderLineToDto(line);
        BeerDto beerDto = beerOrderRestTemplateService.getBeerByUpc(beerOrderLineDto.getUpc());
        beerOrderLineDto.setBeerId(beerDto.getId());
        beerOrderLineDto.setBeerName(beerDto.getBeerName());
        return beerOrderLineDto;
    }
}
