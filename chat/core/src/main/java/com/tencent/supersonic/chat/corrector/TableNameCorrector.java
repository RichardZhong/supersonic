package com.tencent.supersonic.chat.corrector;

import com.tencent.supersonic.chat.api.pojo.CorrectionInfo;
import com.tencent.supersonic.common.util.jsqlparser.SqlParserUpdateHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableNameCorrector extends BaseSemanticCorrector {

    public static final String TABLE_PREFIX = "t_";

    @Override
    public CorrectionInfo corrector(CorrectionInfo correctionInfo) {
        Long modelId = correctionInfo.getParseInfo().getModelId();
        String sqlOutput = correctionInfo.getSql();
        String replaceTable = SqlParserUpdateHelper.replaceTable(sqlOutput, TABLE_PREFIX + modelId);
        correctionInfo.setSql(replaceTable);
        return correctionInfo;
    }

}