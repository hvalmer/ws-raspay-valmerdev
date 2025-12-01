package com.rasmoo.client.raspay.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                    new Info()
                            .title("Raspay")
                            .description("API para credenciamento FAKE de transações financeiras")
                            .version("1.0.0")
                            .license(new io.swagger.v3.oas.models.info.License()
                                    .name("Rasmoo cursos de tecnologia"))
                )
                .addTagsItem(new Tag().name("Cliente").description(
                        "Ao receber os dados do cliente [...] retorna o customer_id."
                ))
                .addTagsItem(new Tag().name("Pedido").description(
                        "Ao enviar os dados do produto e do cliente [...] retorna o order_id."
                ))
                .addTagsItem(new Tag().name("Pagamento").description(
                        "Para realizar o pagamento é necessário customer_id, order_id e dados do cartão [...]"
                ))
                .addTagsItem(new Tag().name("Produto").description(
                        "Produtos possuem uma sigla única. Caso já exista, a API retorna erro."
                ));
    }

}
