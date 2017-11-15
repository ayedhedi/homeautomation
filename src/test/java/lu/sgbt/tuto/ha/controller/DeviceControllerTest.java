package lu.sgbt.tuto.ha.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import lu.sgbt.tuto.ha.domain.json.DtoDevice;
import lu.sgbt.tuto.ha.domain.model.Device;
import lu.sgbt.tuto.ha.fixture.DeviceFixture;
import lu.sgbt.tuto.ha.service.DeviceService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DeviceController.class)
public class DeviceControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private DeviceService deviceService;


	@Test
	public void testGetAllDevice() throws Exception {
		given(this.deviceService.getAllDevices())
				.willReturn(Collections.singletonList(DeviceFixture.createDevice()));

		String content =
				this.mvc.perform(get("/devices").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<DtoDevice> devices = (new ObjectMapper())
				.readValue(content, new TypeReference<List<DtoDevice>>(){});

		assertThat(devices).isNotNull();
		assertThat(devices).hasSize(1);
	}


	@Test
	public void testGetDeviceByIdFound() throws Exception {
		Device device = DeviceFixture.createDevice();
		given(this.deviceService.getDevice(device.getId())).willReturn(device);

		String content =
				this.mvc.perform(get("/devices/"+device.getId())
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		DtoDevice dtoDevice = (new ObjectMapper()).readValue(content, DtoDevice.class);

		assertThat(dtoDevice).isNotNull();
		assertThat(dtoDevice).hasFieldOrPropertyWithValue("id", device.getId());
		assertThat(dtoDevice).hasFieldOrPropertyWithValue("name", device.getName());
	}

	@Test
	public void testGetDeviceByIdNotFound() throws Exception {
		given(this.deviceService.getDevice(123)).willReturn(null);

		this.mvc.perform(get("/devices/123")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}

	@Test
	public void testCreateDevice() throws Exception{
		given(this.deviceService.createDevice(any())).willReturn(DeviceFixture.createDevice());

		DtoDevice dtoDevice = DeviceFixture.createDtoDevice();
		dtoDevice.setId(null);

		String content =
				this.mvc.perform(put("/devices")
				.contentType(MediaType.APPLICATION_JSON)
				.content((new ObjectMapper()).writeValueAsString(dtoDevice)))
				.andExpect(status().isCreated())
				.andReturn().getResponse().getContentAsString();

		assertThat(content).isNotNull();

		dtoDevice = (new ObjectMapper()).readValue(content, DtoDevice.class);
		assertThat(dtoDevice.getId()).isNotNull();
	}

	@Test
	public void testUpdateDevice() throws Exception {
		DtoDevice dtoDevice = DeviceFixture.createDtoDevice();
		given(this.deviceService.getDevice(dtoDevice.getId())).willReturn(DeviceFixture.createDevice());
		given(this.deviceService.updateDevice(any())).willReturn(DeviceFixture.createDevice());

		String content =
				this.mvc.perform(put("/devices")
						.contentType(MediaType.APPLICATION_JSON)
						.content((new ObjectMapper()).writeValueAsString(dtoDevice)))
						.andExpect(status().isAccepted())
						.andReturn().getResponse().getContentAsString();

		assertThat(content).isNotNull();

		dtoDevice = (new ObjectMapper()).readValue(content, DtoDevice.class);
		assertThat(dtoDevice.getId()).isNotNull();
	}

}
