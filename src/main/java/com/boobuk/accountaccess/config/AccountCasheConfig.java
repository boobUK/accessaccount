package com.boobuk.accountaccess.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class AccountCasheConfig {

	@Bean
	Config cashConfig() {
		return new Config().setInstanceName("account-config")
				.addMapConfig(new MapConfig().setName("account-cashe").setTimeToLiveSeconds(3000));
	}

}
