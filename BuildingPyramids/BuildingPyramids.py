def building_Pyramids(blocks):
    import math
    blocks = int(blocks)
    layers_list = []
    for i in range(int(math.sqrt(blocks))):
        i = i+1
        layers_list.append(4*i**2-4*i+1)
    layers = 0
    for layer in layers_list:
        if blocks >= layer:
            blocks -= layer
            layers += 1
        else:
            return layers

print(building_Pyramids(input()))


