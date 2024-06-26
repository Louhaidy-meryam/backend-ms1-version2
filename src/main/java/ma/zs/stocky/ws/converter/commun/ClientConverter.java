package  ma.zs.stocky.ws.converter.commun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.stocky.ws.converter.commun.CategorieClientConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.commun.Client;
import ma.zs.stocky.ws.dto.commun.ClientDto;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientDto> {

    @Autowired
    private CategorieClientConverter categorieClientConverter ;
    private boolean categorieClient;

    public  ClientConverter() {
        super(Client.class, ClientDto.class);
        init(true);
    }

    @Override
    public Client toItem(ClientDto dto) {
        if (dto == null) {
            return null;
        } else {
        Client item = new Client();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getTel()))
                item.setTel(dto.getTel());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getAdresse()))
                item.setAdresse(dto.getAdresse());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getCreance()))
                item.setCreance(dto.getCreance());
            if(this.categorieClient && dto.getCategorieClient()!=null)
                item.setCategorieClient(categorieClientConverter.toItem(dto.getCategorieClient())) ;




        return item;
        }
    }

    @Override
    public ClientDto toDto(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientDto dto = new ClientDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getTel()))
                dto.setTel(item.getTel());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getAdresse()))
                dto.setAdresse(item.getAdresse());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getCreance()))
                dto.setCreance(item.getCreance());
            if(this.categorieClient && item.getCategorieClient()!=null) {
                dto.setCategorieClient(categorieClientConverter.toDto(item.getCategorieClient())) ;

            }


        return dto;
        }
    }

    public void copy(ClientDto dto, Client t) {
    super.copy(dto, t);
    if (dto.getCategorieClient() != null)
        categorieClientConverter.copy(dto.getCategorieClient(), t.getCategorieClient());
    }



    public void initObject(boolean value) {
        this.categorieClient = value;
    }


    public CategorieClientConverter getCategorieClientConverter(){
        return this.categorieClientConverter;
    }
    public void setCategorieClientConverter(CategorieClientConverter categorieClientConverter ){
        this.categorieClientConverter = categorieClientConverter;
    }
    public boolean  isCategorieClient(){
        return this.categorieClient;
    }
    public void  setCategorieClient(boolean categorieClient){
        this.categorieClient = categorieClient;
    }
}
