package org.mj.bizserver.cmdhandler.game.MJ_weihai_;

import io.netty.channel.ChannelHandlerContext;
import org.mj.bizserver.allmsg.MJ_weihai_Protocol;
import org.mj.bizserver.foundation.BizResultWrapper;
import org.mj.bizserver.mod.game.MJ_weihai_.MJ_weihai_BizLogic;
import org.mj.bizserver.mod.game.MJ_weihai_.report.ReporterTeam;
import org.mj.comm.cmdhandler.ICmdHandler;

/**
 * 麻将过牌指令处理器
 */
public final class MahjongGuoCmdHandler extends AbstractInGameCmdHandler<MJ_weihai_Protocol.MahjongGuoCmd>
    implements ICmdHandler<MJ_weihai_Protocol.MahjongGuoCmd> {

    @Override
    public void handle(
        ChannelHandlerContext ctx,
        int remoteSessionId,
        int fromUserId,
        MJ_weihai_Protocol.MahjongGuoCmd cmdObj) {
        // 将复杂工作交给代理, 我只执行省心的调用
        super.doProxyInvoke(ctx, remoteSessionId, fromUserId, cmdObj);
    }

    @Override
    protected void doEasyInvoke(
        int fromUserId, MJ_weihai_Protocol.MahjongGuoCmd cmdObj, BizResultWrapper<ReporterTeam> resultX) {
        // 过牌
        MJ_weihai_BizLogic.getInstance().guo(
            fromUserId, resultX
        );
    }
}
