package org.itxtech.synapseapi.utils;

import cn.nukkit.network.protocol.*;

import java.util.Arrays;

/**
 * DataPacketEidReplacer
 * ===============
 * author: boybook
 * EaseCation Network Project
 * codefuncore
 * ===============
 */
public class DataPacketEidReplacer {

    public static DataPacket replace(DataPacket pk, long from, long to) {
        DataPacket packet = pk.clone();
        switch (packet.pid()) {
            case AnimatePacket.NETWORK_ID:
                if (((AnimatePacket) packet).eid == from) ((AnimatePacket) packet).eid = to;
                break;
            case TakeItemEntityPacket.NETWORK_ID:
                if (((TakeItemEntityPacket) packet).entityId == from) ((TakeItemEntityPacket) packet).entityId = to;
                break;
            case SetEntityMotionPacket.NETWORK_ID:
                if (((SetEntityMotionPacket) packet).eid == from) ((SetEntityMotionPacket) packet).eid = to;
                break;
            case SetEntityLinkPacket.NETWORK_ID:
                if (((SetEntityLinkPacket) packet).rider == from) ((SetEntityLinkPacket) packet).rider = to;
                if (((SetEntityLinkPacket) packet).riding == from) ((SetEntityLinkPacket) packet).riding = to;
                break;
            case SetEntityDataPacket.NETWORK_ID:
                if (((SetEntityDataPacket) packet).eid == from) ((SetEntityDataPacket) packet).eid = to;
                break;
            case UpdateAttributesPacket.NETWORK_ID:
                if (((UpdateAttributesPacket) packet).entityId == from) ((UpdateAttributesPacket) packet).entityId = to;
                break;
            case EntityEventPacket.NETWORK_ID:
                if (((EntityEventPacket) packet).eid == from) ((EntityEventPacket) packet).eid = to;
                break;
            case MovePlayerPacket.NETWORK_ID:
                if (((MovePlayerPacket) packet).eid == from) ((MovePlayerPacket) packet).eid = to;
                break;
            case MobEquipmentPacket.NETWORK_ID:
                if (((MobEquipmentPacket) packet).eid == from) ((MobEquipmentPacket) packet).eid = to;
                break;
            case MobEffectPacket.NETWORK_ID:
                if (((MobEffectPacket) packet).eid == from) ((MobEffectPacket) packet).eid = to;
                break;
            case MoveEntityPacket.NETWORK_ID:
                if (((MoveEntityPacket) packet).eid == from) ((MoveEntityPacket) packet).eid = to;
                break;
            case MobArmorEquipmentPacket.NETWORK_ID:
                if (((MobArmorEquipmentPacket) packet).eid == from) ((MobArmorEquipmentPacket) packet).eid = to;
                break;
            case PlayerListPacket.NETWORK_ID:
                Arrays.stream(((PlayerListPacket) packet).entries).filter(entry -> entry.entityId == from).forEach(entry -> entry.entityId = to);
                break;
            case BossEventPacket.NETWORK_ID:
                if (((BossEventPacket) packet).bossEid == from) ((BossEventPacket) packet).bossEid = to;
                break;
            case AdventureSettingsPacket.NETWORK_ID:
                if (((AdventureSettingsPacket) packet).entityUniqueId == from) ((AdventureSettingsPacket) packet).entityUniqueId = to;
                break;
            case ProtocolInfo.UPDATE_EQUIPMENT_PACKET:
                if (((UpdateEquipmentPacket) packet).eid == from) ((UpdateEquipmentPacket) packet).eid = to;
                break;
            default:
                return pk; //return origin packet object
        }
        //Force encode!
        packet.encode();
        packet.isEncoded = true;
        return packet;
    }

    /*public void replaceMetadata(EntityMetadata data, long from, long to) {
        if(data.getLong(Entity.DATA_OWNER_EID) == from) data.set
    }*/
}
