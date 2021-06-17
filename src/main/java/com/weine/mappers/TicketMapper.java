package com.weine.mappers;

import com.weine.entities.*;
import com.weine.models.dtos.CityDto;
import com.weine.models.dtos.PurchaseItemDto;
import com.weine.models.dtos.TicketDto;

import java.util.*;


public class TicketMapper {
    public TicketMapper() {
    }

    public void setRelation(Ticket ticket){
        if(ticket.getPurchaseItems() != null)
        {
            for (PurchaseItem item : ticket.getPurchaseItems())
            {
                item.setTicket(ticket);
            }
        }
    }
    public TicketDto toTicketDto(Ticket ticket) {
        if (ticket == null) {
            return null;
        } else {
            TicketDto ticketDto = new TicketDto();
            Set<PurchaseItemDto> set = this.purchaseItemSetToPurchaseItemDtoSet(ticket.getPurchaseItems());
            if (set != null) {
                ticketDto.setPurchaseList(set);
            }

            if (ticket.getId() != null) {
                ticketDto.setId(ticket.getId());
            }

            if (ticket.getIdUser() != null) {
                ticketDto.setIdUser(ticket.getIdUser());
            }

            if (ticket.getDateTime() != null) {
                ticketDto.setDateTime(ticket.getDateTime());
            }

            if (ticket.getTotalPrice() != null) {
                ticketDto.setTotalPrice(ticket.getTotalPrice());
            }

            if (ticket.getZipCode() != null) {
                ticketDto.setZipCode(ticket.getZipCode());
            }

            if (ticket.getAddress() != null) {
                ticketDto.setAddress(ticket.getAddress());
            }

            if (ticket.getCity() != null) {
                ticketDto.setCity(this.toCity(ticket.getCity()));
            }

            return ticketDto;
        }
    }

    public List<TicketDto> ticketsToTicketsDto(List<Ticket> ticket) {
        if (ticket == null) {
            return null;
        } else {
            List<TicketDto> list = new ArrayList(ticket.size());
            Iterator var3 = ticket.iterator();

            while(var3.hasNext()) {
                Ticket ticket1 = (Ticket)var3.next();
                list.add(this.toTicketDto(ticket1));
            }

            return list;
        }
    }

    public Ticket toTicket(TicketDto ticketDto) {
        if (ticketDto == null) {
            return null;
        } else {
            Ticket ticket = new Ticket();
            Set<PurchaseItem> set = this.purchaseItemDtoSetToPurchaseItemSet(ticketDto.getPurchaseList());
            if (set != null) {
                ticket.setPurchaseItems(set);
            }

            if (ticketDto.getId() != null) {
                ticket.setId(ticketDto.getId());
            }

            if (ticketDto.getIdUser() != null) {
                ticket.setIdUser(ticketDto.getIdUser());
            }

            if (ticketDto.getDateTime() != null) {
                ticket.setDateTime(ticketDto.getDateTime());
            }

            if (ticketDto.getTotalPrice() != null) {
                ticket.setTotalPrice(ticketDto.getTotalPrice());
            }

            if (ticketDto.getZipCode() != null) {
                ticket.setZipCode(ticketDto.getZipCode());
            }

            if (ticketDto.getAddress() != null) {
                ticket.setAddress(ticketDto.getAddress());
            }

            if (ticketDto.getCity() != null) {
                ticket.setCity(this.cityDtoToCity(ticketDto.getCity()));
            }

            return ticket;
        }
    }

    public PurchaseItemDto toPurchaseItemDto(PurchaseItem purchaseItem) {
        if (purchaseItem == null) {
            return null;
        } else {
            PurchaseItemDto purchaseItemDto = new PurchaseItemDto();
            if (purchaseItem.getId() != null) {
                purchaseItemDto.setId(purchaseItemDto.getId());
            }

            if(purchaseItem.getProduct() != null){
                purchaseItemDto.setIdProduct(purchaseItem.getProduct().getId());
            }

            if (purchaseItem.getAmount() != null) {
                purchaseItemDto.setAmount(purchaseItem.getAmount());
            }

            return purchaseItemDto;
        }
    }

    public PurchaseItem toPurchaseItem(PurchaseItemDto purchaseItemDto) {
        if ( purchaseItemDto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        purchaseItem.setProduct( purchaseItemDtoToProduct( purchaseItemDto ) );

        purchaseItem.setId(purchaseItemDto.getId());

        if ( purchaseItemDto.getAmount() != null ) {
            purchaseItem.setAmount( purchaseItemDto.getAmount() );
        }

        return purchaseItem;
    }

    public List<CityDto> cityListToCityDtoList(List<City> cities) {
        if (cities == null) {
            return null;
        } else {
            List<CityDto> list = new ArrayList(cities.size());
            Iterator var3 = cities.iterator();

            while(var3.hasNext()) {
                City city = (City)var3.next();
                list.add(this.toCity(city));
            }

            return list;
        }
    }

    public CityDto toCity(City city) {
        if (city == null) {
            return null;
        } else {
            CityDto cityDto = new CityDto();
            if (city.getId() != null) {
                cityDto.setId(city.getId());
            }

            if (city.getName() != null) {
                cityDto.setName(city.getName());
            }

            return cityDto;
        }
    }

    public City cityDtoToCity(CityDto cityDto) {
        if (cityDto == null) {
            return null;
        } else {
            City city = new City();
            if (cityDto.getId() != null) {
                city.setId(cityDto.getId());
            }

            if (cityDto.getName() != null) {
                city.setName(cityDto.getName());
            }

            return city;
        }
    }

    protected Set<PurchaseItemDto> purchaseItemSetToPurchaseItemDtoSet(Set<PurchaseItem> set) {
        if (set == null) {
            return null;
        } else {
            Set<PurchaseItemDto> set1 = new HashSet(Math.max((int)((float)set.size() / 0.75F) + 1, 16));
            Iterator var3 = set.iterator();

            while(var3.hasNext()) {
                PurchaseItem purchaseItem = (PurchaseItem)var3.next();
                set1.add(this.toPurchaseItemDto(purchaseItem));
            }

            return set1;
        }
    }

    protected Set<PurchaseItem> purchaseItemDtoSetToPurchaseItemSet(Set<PurchaseItemDto> set) {
        if (set == null) {
            return null;
        } else {
            Set<PurchaseItem> set1 = new HashSet(Math.max((int)((float)set.size() / 0.75F) + 1, 16));
            Iterator var3 = set.iterator();

            while(var3.hasNext()) {
                PurchaseItemDto purchaseItemDto = (PurchaseItemDto)var3.next();
                set1.add(this.toPurchaseItem(purchaseItemDto));
            }

            return set1;
        }
    }


    protected Product purchaseItemDtoToProduct(PurchaseItemDto purchaseItemDto) {
        if (purchaseItemDto == null) {
            return null;
        } else {
            Product product = new Product();
            if (purchaseItemDto.getId() != null) {
                product.setId(purchaseItemDto.getIdProduct());
            }

            return product;
        }
    }
}
