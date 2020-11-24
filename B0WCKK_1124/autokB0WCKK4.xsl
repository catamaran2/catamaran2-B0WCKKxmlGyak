<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    
    <xsl:template match="/">
        <html>
            <body>
                <h2>Miskolci rendszámok</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>Rendszámok</th>
                    </tr>
                    <xsl:for-each select="autok/auto">
                        <tr>
                            <td><xsl:value-of select="@rsz /tulaj[varos ='Miskolc']"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
    
    
    
    
</xsl:stylesheet>