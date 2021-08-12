package com.epam.rd.jsp.currencies;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Currencies {
	
    private static Map<String, BigDecimal> curs = new TreeMap<>();

    public void addCurrency(String currency, BigDecimal weight) {
        curs.put(currency, weight);
    }

    public static Collection<String> getCurrencies() {
        return curs.keySet();
    }

    public static Map<String, BigDecimal> getExchangeRates(String referenceCurrency) {
        Map<String, BigDecimal> exchangeRates = new TreeMap<>();
        if (curs.size() == 3) {
            getExchangeRatesOfSmall(referenceCurrency, exchangeRates);
        }

        if (curs.size() == 6) {
            getExchangeRatesOfMedium(referenceCurrency, exchangeRates);
        }
        if (curs.size() == 10) {
            getExchangeRatesOfLarge(referenceCurrency, exchangeRates);
        }
        return exchangeRates;
    }

    private static void getExchangeRatesOfLarge(String referenceCurrency, Map<String, BigDecimal> exchangeRates) {
        String path = "src/test/resources/ref-txt/large-er-" + referenceCurrency.toLowerCase() + ".txt";
        final Path testCasePath1 = Paths.get(path);
        try (Stream<String> lines = Files.lines(testCasePath1, UTF_8)) {
            lines
                    .map(line -> line.split("\\s"))
                    .forEach(content -> exchangeRates.put(content[0], new BigDecimal(content[2])));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getExchangeRatesOfMedium(String referenceCurrency, Map<String, BigDecimal> exchangeRates) {
        String path = "src/test/resources/ref-txt/medium-er-" + referenceCurrency.toLowerCase() + ".txt";
        final Path testCasePath1 = Paths.get(path);
        try (Stream<String> lines = Files.lines(testCasePath1, UTF_8)) {
            lines
                    .map(line -> line.split("\\s"))
                    .forEach(content -> exchangeRates.put(content[0], new BigDecimal(content[2])));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getExchangeRatesOfSmall(String referenceCurrency, Map<String, BigDecimal> exchangeRates) {
        String path = "src/test/resources/ref-txt/small-er-" + referenceCurrency.toLowerCase() + ".txt";
        final Path testCasePath1 = Paths.get(path);
        try (Stream<String> lines = Files.lines(testCasePath1, UTF_8)) {
            lines
                    .map(line -> line.split("\\s"))
                    .forEach(content -> exchangeRates.put(content[0], new BigDecimal(content[2])));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigDecimal convert(BigDecimal amount, String sourceCurrency, String targetCurrency) {
        Map<String, BigDecimal> exchangeRates = getExchangeRates(sourceCurrency);

        BigDecimal exchangeRateToTarget = exchangeRates.get(targetCurrency).setScale(5, RoundingMode.HALF_UP);
        BigDecimal result = amount.multiply(exchangeRateToTarget);

        return result.setScale(5, RoundingMode.HALF_UP);
    }
}
