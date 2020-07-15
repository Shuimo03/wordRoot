# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class DictionaryItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    #cn_interpretation = scrapy.Field() #单词中文意思
    #en_interpretation =scrapy.Field() #单词英文意思
    word = scrapy.Field() # 单词
    pos = scrapy.Field() #词性
    pass
