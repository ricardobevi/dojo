package com.mercadolibre.dojos;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.mercadolibre.dojos.dto.CheckoutOptionsDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.mockito.Mockito.mock;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Test
    public void test() throws FileNotFoundException {
        CheckoutOptionsDto checkoutOptionsDto = new GsonBuilder().create().fromJson(loadFile("options.json"), CheckoutOptionsDto.class);

        Assert.assertEquals("MLA0000001", checkoutOptionsDto.getItem().getId());
    }

    private InputStreamReader loadFile(String filename) {
        return new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
    }

}
