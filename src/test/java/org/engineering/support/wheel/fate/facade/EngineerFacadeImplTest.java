package org.engineering.support.wheel.fate.facade;

import org.engineering.support.wheel.fate.infrastructure.persistance.jpa.model.Engineer;
import org.engineering.support.wheel.fate.interfaces.facade.EngineerFacade;
import org.engineering.support.wheel.fate.interfaces.facade.impl.EngineerFacadeImpl;
import org.engineering.support.wheel.fate.service.EngineerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by umer on 4/4/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class EngineerFacadeImplTest {
    @Mock
    EngineerService engineerService;

    @InjectMocks
    EngineerFacade engineerFacade = new EngineerFacadeImpl();

    @Test
    public void testGetEngineers() throws Exception {
        List<Engineer> mockEngineers = new ArrayList<>();
        mockEngineers.add(getEngineer());
        when(engineerService.getEngineers(anyInt())).thenReturn(mockEngineers);

        List<Engineer> actualEngineers = engineerFacade.getEngineers(anyInt());

        assertThat(actualEngineers.get(0).getId(), is(mockEngineers.get(0).getId()));
        verify(engineerService, times(1)).getEngineers(anyInt());
    }

    private Engineer getEngineer(){
        Engineer engineer = new Engineer();
        engineer.setId(1);
        engineer.setFirstName("Alan");
        engineer.setLastName("Walker");
        engineer.setEmail("alan.walker@dummy.com");
        engineer.setUpdationDate(new Timestamp(1));
        engineer.setCreationDate(new Timestamp(1));

        return engineer;
    }
}
