/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.integtests.invoice;

import javax.inject.Inject;
import org.estatio.dom.asset.Properties;
import org.estatio.dom.asset.Property;
import org.estatio.dom.invoice.Invoices;
import org.estatio.dom.numerator.Numerator;
import org.estatio.fixture.EstatioBaseLineFixture;
import org.estatio.fixture.asset.PropertyForKal;
import org.estatio.fixture.asset.PropertyForOxf;
import org.estatio.fixture.lease.*;
import org.estatio.fixture.party.*;
import org.estatio.integtests.EstatioIntegrationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.isis.applib.fixturescripts.FixtureScript;

import static org.junit.Assert.assertNotNull;

public class InvoicesTest_findInvoiceNumberNumerator extends EstatioIntegrationTest {

    @Before
    public void setupData() {
        scenarioExecution().install(new FixtureScript() {
            @Override
            protected void execute(ExecutionContext executionContext) {
                execute(new EstatioBaseLineFixture(), executionContext);

                execute(new PersonForJohnDoe(), executionContext);
                execute(new PersonForLinusTorvalds(), executionContext);

                execute(new OrganisationForHelloWorld(), executionContext);
                execute(new PropertyForOxf(), executionContext);

                execute(new OrganisationForAcme(), executionContext);
                execute(new PropertyForKal(), executionContext);

                execute(new OrganisationForTopModel(), executionContext);
                execute(new LeasesEtcForOxfTopModel001(), executionContext);

                execute(new OrganisationForMediaX(), executionContext);
                execute(new LeasesEtcForOxfMediax002(), executionContext);

                execute(new OrganisationForPoison(), executionContext);
                execute(new LeasesEtcForOxfPoison003(), executionContext);
                execute(new LeasesEtcForKalPoison001(), executionContext);

                execute(new OrganisationForPret(), executionContext);
                execute(new LeasesEtcForOxfPret004(), executionContext);

                execute(new OrganisationForMiracle(), executionContext);
                execute(new LeasesEtcForOxfMiracl005(), executionContext);
            }
        });
    }

    @Inject
    private Invoices invoices;
    @Inject
    private Properties properties;

    private Property property1;

    @Test
    public void whenNone() throws Exception {
        // given
        property1 = properties.findPropertyByReference("OXF");
        assertNotNull(property1);

        // when
        Numerator numerator = invoices.findInvoiceNumberNumerator(property1);
        // then
        Assert.assertNull(numerator);
    }


}
