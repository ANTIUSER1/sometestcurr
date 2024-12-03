package pns.tst.cutr_list.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pns.tst.cutr_list.entities.Currency;

import java.util.ArrayList;
import java.util.List;

/**
 * service for  adding test data
 */
@Service
@Slf4j
public class AddDataService {

    @Autowired
    private CurrencyService currencyService;

    /**
     * add data
     *
     * @return
     */
    public List<Currency> addCurrencyData() {
        List<Currency> result = new ArrayList<>();

        result.add(currencyService.create("AMD"));
        result.add(currencyService.create("RUB"));
        result.add(currencyService.create("TR"));
        result.add(currencyService.create("KZ"));
        result.add(currencyService.create("GB"));
        result.add(currencyService.create("FR"));
        result.add(currencyService.create("USD"));
        log.info(" CREATE CURRENCY SET   " + result);

        return result;
    }
}
