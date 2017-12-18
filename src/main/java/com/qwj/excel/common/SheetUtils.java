/**
 * Copyright (C), 2015-2017
 * FileName: SheetUtils
 * Author:   qianwenjun
 * Date:     2017/12/15 10:44
 * Description: sheet操作工具类
 */
package com.qwj.excel.common;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 〈sheet操作工具类〉
 *
 * @author qianwenjun
 * @create 2017/12/15
 * @since 1.0.0
 */
public class SheetUtils {

    /**
     * 删除指定的sheet
     *
     * @param wb
     * @param sheetName
     * @return
     */
    public static void removeSheetByName(XSSFWorkbook wb, String sheetName) {

        try {
            wb.removeSheetAt(wb.getSheetIndex(sheetName));
        } catch(Exception e) {
          e.printStackTrace();
        }
    }



}