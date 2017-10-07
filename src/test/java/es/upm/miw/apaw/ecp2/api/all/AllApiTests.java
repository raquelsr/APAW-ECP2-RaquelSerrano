package es.upm.miw.apaw.ecp2.api.all;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.ecp2.api.AllFunctionalTesting;
import es.upm.miw.apaw.ecp2.api.controllers.AllApiControllersTests;
import es.upm.miw.apaw.ecp2.api.daos.memory.AllApiDaosMemoryTests;
import es.upm.miw.apaw.ecp2.api.entities.AllBuilderTests;

@RunWith(Suite.class)
@SuiteClasses({AllApiControllersTests.class, AllFunctionalTesting.class, AllApiDaosMemoryTests.class, AllBuilderTests.class})

public class AllApiTests {

}
