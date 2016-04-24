package com.romajs.models.extract;

import io.yawp.repository.pipes.Pipe;

import com.romajs.models.balancechange.BalanceChange;
import com.romajs.models.extract.Extract.Type;

public class BalanceChangeExtractPipe extends Pipe<BalanceChange, Extract> {

	static final Type type = Extract.Type.BALANCE;

	@Override
	public void configureSinks(BalanceChange balanceChange) {
		// addSinkId(id(Extract.class, balanceChange.getId().asLong()));
	}

	@Override
	public void flux(BalanceChange balanceChange, Extract extract) {
		extract.setAmount(balanceChange.getIncreasedValue());
		extract.setDate(balanceChange.getDate());
		extract.setDescription(type.toString());
		extract.setType(type);
	}

	@Override
	public void reflux(BalanceChange balanceChange, Extract extract) {
		// ???
	}
}
