package com.mercadolibre.dojos;


import com.mercadolibre.dojos.transport.Bus;
import com.mercadolibre.dojos.transport.Train;
import com.mercadolibre.dojos.transport.Transport;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the dojo.
 */
public class DojoTest {

    @Test
    public void test_un_viaje_de_buenos_aires_a_mar_del_plata_en_micro_vale_1000_pesos() {

        Trip trip = new Trip(
                new Bus(
                        new Section(
                                new Place("Buenos_aires", 0.0),
                                new Place("Mar_del_plata", 100.0)
                        )
                )
        );

        Assert.assertEquals(trip.cost(), new Price(1000.00));
    }

    @Test
    public void test_un_viaje_de_buenos_aires_a_mar_del_plata_en_tren_vale_500_pesos() {

        Trip trip = new Trip(
                new Train(
                        new Section(
                                new Place("Buenos_aires", 0.0),
                                new Place("Mar_del_plata", 100.00)
                        )
                )
        );

        Assert.assertEquals(trip.cost(), new Price(500.00));
    }

    @Test
    public void test_un_viaje_de_buenos_aires_a_trelew_en_tren_vale_2000_pesos() {

        Trip trip = new Trip(
                new Train(
                        new Section(
                                new Place("Buenos_aires", 0.0),
                                new Place("Trelew", 1200.0)
                        )
                )
        );

        Assert.assertEquals(trip.cost(), new Price(6000.00));
    }


    @Test
    public void test_un_viaje_de_buenos_aires_a_trelew_pasando_por_bahia_white_en_bus() {


        Trip trip = new Trip(
                new Bus(
                        new Section(
                                new Place("Buenos_aires", 0.0),
                                new Place("Bahia_blanca", 600.0)
                        )
                ),
                new Bus(
                        new Section(
                                new Place("Bahia_blanca", 600.0),
                                new Place("trelew", 1200.0)
                        )
                )
        );

        Assert.assertEquals(trip.cost(), new Price(12000.00));
    }



}
