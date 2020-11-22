package com.ego.search.client;

import com.ego.item.api.SpecApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("item-service")
public interface SpecClient extends SpecApi {
}
