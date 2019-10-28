from PIL import Image


def split_image():
    imgwidth, imgheight = im.size
    resize_factor = 1
    h = 4
    b = 3
    width_sep = int(imgwidth / b)
    heigh_sep = int(imgheight / h)
    res_width = int(width_sep * resize_factor)
    res_height = int(heigh_sep * resize_factor)
    count = 1

    for i in range(h):
        for j in range(b):
            region = im.crop((j * width_sep, i * heigh_sep, (j + 1) * width_sep, (i + 1) * heigh_sep))
            if resize_factor != 1:
                region = region.resize((res_width, res_height))
            # region = region.resize((250, 250), Image.ANTIALIAS)
            region.save(r"C:\AndroidProjects\Adventskalender\trunk\python_image_slicer\zahl_%02d.png" % count)
            count += 1


if __name__ == '__main__':
    im = Image.open(r"av2.PNG")
    split_image()
